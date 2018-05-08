package struts2;

/**
 * Java入門 Struts2サンプル DTOクラス.</br>
 * DTO（Data Transfer Object）とは、データを画面等に受け渡すための箱の役割.
 */
public class SampleDto {

	private String name;	// インスタンス名
	
	/**
	 * インスタンス名を設定します.
	 * @param name インスタンス名
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * インスタンス名を返却します.
	 * @return インスタンス名
	 */
	public String getName() {
		return this.name;
	}
}