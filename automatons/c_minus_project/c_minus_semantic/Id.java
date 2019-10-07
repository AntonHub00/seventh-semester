public class Id{

    public String name; //the lexem
    public String type; //int, real, void
    public String category; //variable, array, function
    public int size; //array size or amount of parameters

    public Id(String name, String type, String category, int size){
        this.name = name;
        this.type = type;
        this.category = category;
        this.size = size;
    }

    @Override
    public String toString(){
        return String.format("%20s%20s%20s%20s", name, type, category, size);
    }
}
