package test.example.com.forceoffline;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.WindowManager;

/**
 * Created by echo on 2015/8/7.
 */
public class ForceOfflineReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(final Context context, Intent intent) {
        AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(context);
        dialogBuilder.setTitle("warning");
        dialogBuilder.setMessage("You are forced to be offline,pleast try to login later");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityCollector.finishAll();
                Intent intent = new Intent(context, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);//��������logonactivity
            }
        });
        AlertDialog alertDialog=dialogBuilder.create();
        //��Ҫ����Alertdialog�����ͣ���֤�ڹ㲥�������п�����������
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();
    }
}
