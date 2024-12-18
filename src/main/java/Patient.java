public class Patient extends User {
    private String birthday;
    private double weight;
    private double height;
    private String bloodType;

    Patient(String name, String email) {
        // Super representa al objeto padre
        super(name, email);
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHeight() {
        return this.height + " m.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    //70.0 kg.
    // Las reglas de negocio se deben establecer dentro de la clase, como en esta clase.
    public String getWeight(){
        return this.weight + " kg.";
    }
    public void setWeight(double weight){
        this.weight = weight;
    }

    public void setPhoneNumber(String phoneNumber){
        if (phoneNumber.length() != 10) {
            System.out.println("El número telefónico debe ser de 10 dígitos");
        }
    }
}