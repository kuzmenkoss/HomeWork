class TapeDec {
    boolean canRecord = false ;
    void playTape () {
        System.out.println("пленка проигрывается");
    }
    void recordTape () {
        System.out.println("идет запись на пленку");
    }
}

class TapeDecTestDrive {
    public static void main(String[] args) {
        TapeDec t = new TapeDec();
        t.canRecord = true;
        t.playTape();
        if (t.canRecord==true){
            t.recordTape ();
        }
    }
}

// это однострочный комментарий

/*
это
многострочный
комментарий
 */