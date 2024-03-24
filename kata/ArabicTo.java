package kata;

public enum ArabicTo {
    ONE(1,"I"),
    TWO(2,"II"),
    THREE(3,"III"),
    FOUR(4,"IV"),
    FIVE(5,"V"),
    SIX(6,"VI"),
    SEVEN(7,"VII"),
    EIGHT(8,"VIII"),
    NINE(9,"IX"),
    TEN(10,"X"),
    TWENTY(20,"XX"),
    THIRTY(30,"XXX"),
    FORTY(40,"XL"),
    FIFTY(50,"L"),
    SIXTY(60,"LX"),
    SEVENTY(70,"LXX"),
    EIGHTY(80,"LXXX"),
    NINETY(90,"XC"),
    HUNDRED(100,"C");
    private final int arab;
    private final String rom;
    ArabicTo(int arab, String rom){
        this.arab=arab;
        this.rom=rom;
    }
    public static String reconvert(int res){
        for(ArabicTo arabic:ArabicTo.values()){
            if(res/arabic.arab==1&&res%arabic.arab==0){
                return arabic.rom;
            }
            else if(res/arabic.arab==1&&res%arabic.arab<10){
                return arabic.rom+reconvert(res%arabic.arab);
            }
        }
       return null;
    }
    public static int convert(String task)throws Exception{
        for(ArabicTo arabic:ArabicTo.values()){
            if(arabic.rom.equals(task)){
                if(arabic.arab<=10){
                return arabic.arab;
                }
            }
        }
        throw new Exception("Неподходящее число");
    }
}
