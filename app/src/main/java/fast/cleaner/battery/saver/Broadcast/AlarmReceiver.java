package fast.cleaner.battery.saver.Broadcast;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


import com.example.intagpc.myapplication.R;

import fast.cleaner.battery.saver.MainActivity;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by intag pc on 10/5/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {

            Toast.makeText(context, "HGello", Toast.LENGTH_SHORT).show();

            Intent notificationIntent = new Intent(context, MainActivity.class);
            PendingIntent intentt = PendingIntent.getActivity(context, 0,
                    notificationIntent, 0);
            Notification notification = new Notification.Builder(context)
                    .setContentTitle(context.getResources().getString(R.string.title_notefication))
                    .setContentText(context.getResources().getString(R.string.detail_notification))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(intentt).setAutoCancel(true)
                    .setDefaults(Notification.DEFAULT_SOUND
                            | Notification.DEFAULT_VIBRATE)
                    .build();
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);


            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                    | Intent.FLAG_ACTIVITY_SINGLE_TOP);




            notification.flags |= Notification.FLAG_AUTO_CANCEL;
            notificationManager.notify(0, notification);


//            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Activity.NOTIFICATION_SERVICE);
//            Intent notificationIntent = new Intent(
//                    context.getApplicationContext(), MainActivity.class);
//            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
//            stackBuilder.addParentStack(MainActivity.class);
//            stackBuilder.addNextIntent(notificationIntent);
//            PendingIntent pIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//            Notification notification = new Notification.Builder(context)
//                    .setContentTitle("Title")
//                    .setContentText("Detail about it")
//                    .setDefaults(Notification.DEFAULT_SOUND
//                            | Notification.DEFAULT_VIBRATE)
//                    .setContentIntent(pIntent).setAutoCancel(true)
//                    .setSmallIcon(R.mipmap.ic_launcher).build();
//            notificationManager.notify(0, notification);
        }
    }
}
