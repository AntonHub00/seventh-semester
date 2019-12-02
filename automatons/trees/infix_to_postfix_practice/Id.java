public class Id{

    public String name; //the lexem
    public String type; //int, real, void
    public String category; //variable, array, function
    public int size; //array size or amount of parameters
    public String value; //value if is a variable

    public Id(String name, String type, String category, int size, String value){
        this.name = name;
        this.type = type;
        this.category = category;
        this.size = size;
        this.value = value;
    }

    @Override
    public String toString(){
        return String.format("%20s%20s%20s%20s%20s", name, type, category, size, value);
    }
}
