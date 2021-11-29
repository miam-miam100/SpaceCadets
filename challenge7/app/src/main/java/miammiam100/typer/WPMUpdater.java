package miammiam100.typer;

import android.os.Handler;
import android.widget.TextView;

class WPMUpdater implements Runnable {

    private final Handler handler;
    private final int delay;
    private final TextView textView;
    public int charsWritten;
    public long startTime;
    public Long endTime;

    public WPMUpdater(Handler handler, TextView textView, int delay) {
        this.delay = delay;
        this.handler = handler;
        this.textView = textView;
    }

    public void run() {
        if (charsWritten == 0) {
            handler.postDelayed(this, 50);
            return;
        }
        handler.postDelayed(this, delay);
        long nanoElapsedTime = ((endTime == null) ? System.nanoTime() : endTime) - startTime;
        double elapsedTime = ((double) (nanoElapsedTime) / 1000000000);
        double words = (double) charsWritten / 5;
        int wpm = (int) Math.round((words * 60) / elapsedTime);
        textView.setText(wpm + " wpm");
    }
}
