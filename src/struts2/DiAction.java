package struts2;

import java.util.ArrayList;

import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.ognl.accessor.XWorkCollectionPropertyAccessor;
import com.opensymphony.xwork2.ognl.accessor.XWorkListPropertyAccessor;

import ognl.PropertyAccessor;

/**
 * Java入門 DI確認クラス.<br>
 * Struts2の中で行われているDI（依存性の注入）処理を確認するためのクラス.
 */
public class DiAction {
	
	private ArrayList<SampleDto> list;	// インスタンス名を格納するリスト
	private Container container;		// DIコンテナ
	
	/**
	 * DIコンテナのインスタンスを格納します.</br>
	 * このメソッドの呼び出しはStruts2内で行われます.
	 * @param container DIコンテナ
	 */
	// @Injectアノテーションを使用することでStruts2によってDIコンテナがセットされます.
	@Inject
	public void setContainer(Container container) {
		
		this.container = container;
	}
	
	/**
	 * インスタンス名のリストを返却します.
	 * @return インスタンス名のリスト
	 */
	public ArrayList<SampleDto> getList() {
		return list;
	}
	
	/**
	 * di.actionにアクセスした際に実行されるメソッドです.
	 * @return 処理結果
	 * @throws Exception
	 */
	public String execute() throws Exception {
		
		// DTOクラス（インスタンス名をしまう箱）
		SampleDto dto;
		// DTOクラスを格納するリストを作成
		list = new ArrayList<SampleDto>();

		// 参考にDIしてみる
		// struts-default.xmlに登録されているクラスのインスタンスを取得
		// XWorkListPropertyAccessorクラス（java.util.Listというキーワードで取得）
		XWorkListPropertyAccessor xlpa = 
				(XWorkListPropertyAccessor) container.getInstance(PropertyAccessor.class, "java.util.List");
		
		// DTOクラスに格納
		dto = new SampleDto();
		dto.setName(xlpa.toString());
		list.add(dto);
		
		// XWorkCollectionPropertyAccessorクラス（java.util.Collectionというキーワードで取得）
		XWorkCollectionPropertyAccessor xcpa =
				(XWorkCollectionPropertyAccessor) container.getInstance(PropertyAccessor.class, "java.util.Collection");

		// DTOクラスに格納
		dto = new SampleDto();
		dto.setName(xcpa.toString());
		list.add(dto);
		
		return "success";
	}
}