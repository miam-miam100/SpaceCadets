import ScreenSaver.ScreenSaver;
import Win32Calls.User32;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;

public class Main {
  public static int wait = 5;
  static boolean onWindows = System.getProperty("os.name").contains("Windows");

  public static int getIdleTimeMillis() {
    if (onWindows) {
      User32.LASTINPUTINFO lastInputInfo = new User32.LASTINPUTINFO();
      Win32Calls.User32.INSTANCE.GetLastInputInfo(lastInputInfo);
      return Win32Calls.Kernel32.INSTANCE.GetTickCount() - lastInputInfo.dwTime;
    } else {
      return PointerChecker.getInstance().PointerChanged();
    }
  }

  public static void main(String[] args) throws InterruptedException, InvocationTargetException {

    while (true) {
      int idleSec = getIdleTimeMillis() / 1000;
      if (!ScreenSaver.isActive() && idleSec >= wait) {
        EventQueue.invokeAndWait(new ScreenSaver());
      }
      Thread.sleep(1000);
    }
  }
}
