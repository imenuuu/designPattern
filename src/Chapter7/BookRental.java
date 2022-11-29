package Chapter7;

interface StatePattern{
    public void checkOut();
    public void reserve();
    public void cancel();
    public void returnBook();
}

class book{

}

class available implements StatePattern{

    @Override
    public void checkOut() {

    }

    @Override
    public void reserve() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void returnBook() {

    }
}
class OnLoan implements StatePattern{

    @Override
    public void checkOut() {

    }

    @Override
    public void reserve() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void returnBook() {

    }
}
class reserve implements StatePattern{

    @Override
    public void checkOut() {

    }

    @Override
    public void reserve() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void returnBook() {

    }
}
class kept implements StatePattern{
    @Override
    public void checkOut() {

    }

    @Override
    public void reserve() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void returnBook() {

    }
}
public class BookRental {
    public static void main(String[] args) {

    }
}
