public class Main {

  public static void main(String[] args) {
    Integer X;
    Integer Y;
    Integer Z;
    Integer W;
    X = 0;
    X += 1;
    X += 1;
    Y = 0;
    Y += 1;
    Y += 1;
    Y += 1;
    Z = 0;
    while (X != 0) {
      W = 0;
      while (Y != 0) {
        Z += 1;
        W += 1;
        Y -= 1;
      }
      while (W != 0) {
        Y += 1;
        W -= 1;
      }
      X -= 1;
    }
  }
}