import java.util.Scanner;
class Calc{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//while(true){
			char operation=' ';
			int first;
			int second;
			String rom1;
			String rom2;
			System.out.println("Введите выражение");
			String input = sc.nextLine();
			if(input.length()<2){System.out.print("строка не является математической операцией");}
			//if(input.matches("[+\\-*/]"))System.out.println("!-!-!-!-!");
			//if(!input.matches("+")|!input.matches("-")|!input.matches("*")|!input.matches("/"))System.out.print("строка не является математической операцией");
			else{String[] arr = input.split("(?=([+\\-*/]))");
			if(arr.length>2) {System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");}
			else{operation = arr[1].charAt(0);
			for(String x: arr)System.out.println(x);
			System.out.println(operation);
			rom1=arr[0];
			rom2=arr[1].substring(1);
			System.out.println(rom1+"--"+rom2);
			//if(operation==' ')System.out.print("строка не является математической операцией");
			if(rom1.matches("[0-9]+") && rom2.matches("[0-9]+")){
				first=Integer.parseInt(rom1);
				second=Integer.parseInt(rom2);
				System.out.print(first+" "+operation+" "+second+"=");
				System.out.println(Calc.oper(operation,first, second));}
				
			if(rom1.matches("[I,X,V,L,C]+") && rom2.matches("[I,X,V,L,C]+")){
				first=Calc.toArab(rom1);
				second=Calc.toArab(rom2);
				if(first<second&&operation=='-')System.out.print("в римской системе нет отрицательных чисел");
				else{System.out.print(rom1+" "+operation+" "+rom2+"=");
				System.out.println(Calc.toRom(Calc.oper(operation,first, second)));
				System.out.print("!!!");}
				}
			
			if((rom1.matches("[I,X,V,L,C]+") && rom2.matches("[0-9]+"))||(rom1.matches("[0-9]+") && rom2.matches("[I,X,V,L,C]+")))System.out.print("используются одновременно разные системы счисления");
			}}
			//System.out.print("строка не является математической операцией");
		//}//while
		
	}//main
	static int oper(char op,int x, int y){
		int result=0;
		if(op=='+')result=x+y;
		if(op=='-')result=x-y;
		if(op=='*')result=x*y;
		if(op=='/')result=x/y;
			return result;
	}//oper
	 static int toArab(String num){
		String[] rom = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
		for(int i=0; i<rom.length; i++) {if(rom[i].equals(num)) return i;}
		return 0;
	}//toArab
	 static String toRom(int num){
		String[] rom = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
		
		return rom[num];
	}//toRom
}//calc