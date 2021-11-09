package Exception;

public class LibraryException extends RuntimeException{
	
	private String info;
	public LibraryException(String info)
	{
		this.info =info;
	}
	public String getInfo(){
		return info;
		
	}

}
