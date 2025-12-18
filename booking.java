class bookmovie{
 int total_seats = 9;
 public synchronized void bookSeat (int seats){
 //synchronized (this) {
 if (total_seats >= seats) {
 System.out.println(seats + " Seats Booked");
 total_seats = total_seats - seats;
 } else {
 System.out.println("Available seats Are " + total_seats);
 }
 // }
 }
}
public class booking extends Thread{
 static bookmovie b; // static shared between all instances of that class, not the actual objects themselves.
 int seats;
 public void run()
 {
 b.bookSeat(seats);
 }
 public static void main(String[] args) {
 b = new bookmovie(); // Create new Objects and it is used to allocate dynamic memory at runtime
 booking c1 = new booking();
 c1.seats = 7;
 booking c2 = new booking();
 c2.seats = 5;
 c1.start();
 c2.start();
 }
}