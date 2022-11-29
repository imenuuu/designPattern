package Chapter3;

import java.util.Calendar;

interface TimeProvider {
   void setHours(int hours);
   int getTime();
}

class FakeTimeProvider implements TimeProvider{
    private Calendar cal;
    public FakeTimeProvider(){
        cal = Calendar.getInstance();
    }
    public FakeTimeProvider(int hours){
        cal=Calendar.getInstance();
        setHours(hours);
    }

    public void setHours(int hours) {
        cal.set(Calendar.HOUR_OF_DAY, hours);
        setHours(hours);
    }

    public int getTime() {
        return cal.get(Calendar.HOUR_OF_DAY);
    }
}

public class Mp3 {
    TimeProvider tProv;
    MP3 m = new MP3();
    public void setTimeProvider (TimeProvider tProv){
        this.tProv = tProv;
    }
    public void remainder () {
        int hours = tProv.getTime();
        if (hours >= 22) {
            m.playSong();
        }
    }
}
class MP3{
    public void playSong() {
        System.out.println("play Song");
    }
}
