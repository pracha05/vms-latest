package com.vms.customer.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.vms.customer.R;
import com.vms.customer.constant.Constant;
import com.vms.customer.constant.ReceiverConstant;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SMSReceiver extends BroadcastReceiver {

    final SmsManager sms = SmsManager.getDefault();
    public Pattern pattern = Pattern.compile("(|^)\\d{6}");

    @Override
    public void onReceive(Context context, Intent intent) {
        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();
        readSms(bundle, context);
    }


    private void readSms(Bundle bundle, Context ctx) {

        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody().toLowerCase(Locale.US).replace("-", "");
                    if (message.toLowerCase().contains(ctx.getString(R.string.otp_message_format).toLowerCase())) {
                        if (message != null) {
                            Matcher m = pattern.matcher(message);
                            if (m.find()) {
                                Intent broadcastIntent = new Intent();
                                broadcastIntent.setAction(ReceiverConstant.ACTION_RECEIVE_SMS_SUCCESS);
                                broadcastIntent.putExtra(Constant.STRING_EXTRA, m.group(0));
                                LocalBroadcastManager.getInstance(ctx).sendBroadcast(broadcastIntent);
                            }
                        }
                    }
                } // end for loop
            } // bundle is null
        } catch (Exception e) {
        }
    }//read sms
}

