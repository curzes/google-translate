import Translator.Translate;

public class Main {
	
	public static void main(String[] args){
		String[] trans = Translate.translate("Hej hur �r l�get?", "en", "sv");

		for(String s : trans){
			System.out.println( s );
		}

    }

}
