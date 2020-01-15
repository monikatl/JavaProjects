package elements.triad;

import fundamental_date.KeyNames;
import elements.Note;

public abstract class Triads implements Triad {

    private Note prime;
    private Note third;
    private Note quint;
    private String nameTriad;

    public Triads(Note prime, Note third, Note quint, String nameTriad) {
        this.prime = prime;
        this.third = third;
        this.quint = quint;
        this.nameTriad = nameTriad;
    }

    public Triads(String nameTriad) {
        this.nameTriad = nameTriad;
    }

    public static Triads choseModeOfTriad(String key) {
        char keyChar = key.charAt(0);
        Triads triad;
        if(Character.isUpperCase(keyChar)){
            triad = new MajorTriad(key);
        }else{
            triad = new MinorTriad(key);
        }
        return triad;
    }

    public void buildTriad(){
        Note primeOfTriad = findPrime(KeyNames.keyBoard, nameTriad);
        Note thirdOfTriad = findThird(primeOfTriad);
        Note quintOfTriad = findQuint(primeOfTriad);
        setPrime(primeOfTriad);
        setThird(thirdOfTriad);
        setQuint(quintOfTriad);
    }

    public void buildTriad(String primeOfTriadName){
        Note primeOfTriad = findPrime(KeyNames.keyBoard, primeOfTriadName);
        Note thirdOfTriad = findThird(primeOfTriad);
        Note quintOfTriad = findQuint(primeOfTriad);
        setPrime(primeOfTriad);
        setThird(thirdOfTriad);
        setQuint(quintOfTriad);
    }

    public Note findPrime(String[][] notes, String primeOfTriad) {
        Note prime = null;
        for (int row = 0; row < notes.length; row++) {
            for (int column = 0; column < notes[row].length; column++) {
                if (primeOfTriad.toLowerCase().equals(notes[row][column])) {
                    prime = new Note(row, column, primeOfTriad.toLowerCase());
                }
            }
        }
        return prime;
    }

    public Note findThird(Note note) {
        int indexOfSound = findIndexOfSoundThird(note.getSound());
        int indexOfName = findIndexOfName(note, indexOfSound);
        String keyName = KeyNames.keyBoard[indexOfSound][indexOfName];
        return new Note(indexOfSound, indexOfName, keyName.toLowerCase());
    }

    public Note findQuint(Note note) {
        int indexOfSound = findIndexOfSoundQuint(note.getSound());
        int indexOfName = findIndexOfName(note, indexOfSound);
        String keyName = KeyNames.keyBoard[indexOfSound][indexOfName];
        return new Note(indexOfSound, indexOfName, keyName.toLowerCase());
    }

    public int findIndexOfName(Note note, int indexSound) {
        int  name = note.getName();
        String nameOfNote = note.getNote();
        if(KeyNames.keyBoard[indexSound][name].equals("x")){
            if(nameOfNote.equals("dis") || nameOfNote.equals("eis")) {
                return 3;
            }else if(nameOfNote.equals("g")||nameOfNote.equals("c") || nameOfNote.equals("f") ||
                  nameOfNote.equals("fis")||nameOfNote.equals("cis") || nameOfNote.equals("gis") ){
                return name + 1;
            } else {
                return name - 1;
            }
        } else {
            return name;
        }
    }

    public int findIndexOfSoundQuint(int sound) {
        if (sound > 4) {
            return  (sound + 7) -12;
        } else {
            return sound + 7;}
    }

    public String showModeTriad(){
        char [] name = nameTriad.toCharArray();
        if(Character.isUpperCase(name[0])){
            return "durowy";
        }else {
            return "molowy";
        }
    }

    public String [] downloadNamesOfNotes(){
        String [] triad = new String[3];
        triad [0] = this.prime.getNote();
        triad [1] = this.third.getNote();
        triad [2] = this.quint.getNote();
        return triad;
    }

    public void setPrime(Note prime) {
        this.prime = prime;
    }

    public void setThird(Note third) {
        this.third = third;
    }

    public void setQuint(Note quint) {
        this.quint = quint;
    }

    public Note getPrime() {
        return prime;
    }

    public String getNameTriad() {
        return nameTriad;
    }

    @Override
    public String toString() {
        return  nameTriad +
                " (dzwieki: " + prime +
                ", " + third +
                ", " + quint +
                ")";
    }
}

