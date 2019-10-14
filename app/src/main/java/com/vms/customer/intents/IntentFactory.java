package com.vms.customer.intents;

import android.content.Context;
import android.content.Intent;

import com.vms.customer.activity.AboutAppActivity;
import com.vms.customer.activity.AboutUsActivity;
import com.vms.customer.activity.CustomerMembershipActivity;
import com.vms.customer.activity.IntroductionPagerActivity;
import com.vms.customer.activity.ListOfVechilesActivity;
import com.vms.customer.activity.MoreActivity;
import com.vms.customer.activity.NotificationActivity;
import com.vms.customer.activity.PrivacyPolicyActivity;
import com.vms.customer.activity.ReferenceCodeActivity;
import com.vms.customer.activity.AddContact;
import com.vms.customer.activity.AddLoadActivity;
import com.vms.customer.activity.BasicLoadActivity;
import com.vms.customer.activity.BookingSummery;
import com.vms.customer.activity.ContactAllList;
import com.vms.customer.activity.ContactDetailsInfo;
import com.vms.customer.activity.CustomerSupport;
import com.vms.customer.activity.EditContact;
import com.vms.customer.activity.EditProfile;
import com.vms.customer.activity.InsuranceProvider;
import com.vms.customer.activity.MainFilterActivity;
import com.vms.customer.activity.ProfileActivity;
import com.vms.customer.activity.SignInActivity;
import com.vms.customer.activity.SignUpActivity;
import com.vms.customer.activity.TermsOfUseActivity;
import com.vms.customer.activity.TruckBookingConfirmActivity;
import com.vms.customer.activity.VerifyOtpActivity;
import com.vms.customer.activity.Wallet;

public class IntentFactory {

    /**
     * create intro page activity
     */
    public static Intent createIntroPageActivity(Context context) {
        Intent intent = new Intent(context, IntroductionPagerActivity.class);
        return intent;
    }

    /**
     * create sign in  activity
     */
    public static Intent createUserLoginActivity(Context context) {
        Intent intent = new Intent(context, SignInActivity.class);
        return intent;
    }

    /**
     * create registration activity
     */
    public static Intent createRegistrationActivity(Context context) {
        Intent intent = new Intent(context, SignUpActivity.class);
        return intent;
    }

    /**
     * create add load activity
     */
    public static Intent createAddLoadActivity(Context context) {
        Intent intent = new Intent(context, AddLoadActivity.class);
        return intent;
    }

    /**
     * create reference code activity
     */
    public static Intent createReferenceCodeActivity(Context context) {
        Intent intent = new Intent(context, ReferenceCodeActivity.class);
        return intent;
    }

    /**
     * create profile activity
     */
    public static Intent createProfileActivity(Context context) {
        Intent intent = new Intent(context, ProfileActivity.class);
        return intent;
    }


    /**
     * create all contact activity
     */
    public static Intent createAllContactActivity(Context context) {
        Intent intent = new Intent(context, ContactAllList.class);
        return intent;
    }

    /**
     * create all contact activity
     */
    public static Intent createInsuranceProviderActivity(Context context) {
        Intent intent = new Intent(context, InsuranceProvider.class);
        return intent;
    }

    /**
     * create booking summary activity
     */
    public static Intent createBookingSummaryActivity(Context context) {
        Intent intent = new Intent(context, BookingSummery.class);
        return intent;
    }

    /**
     * create customer support activity
     */
    public static Intent createCustomerSupportActivity(Context context) {
        Intent intent = new Intent(context, CustomerSupport.class);
        return intent;
    }

    /**
     * create wallet activity
     */
    public static Intent createWalletActivity(Context context) {
        Intent intent = new Intent(context, Wallet.class);
        return intent;
    }

    /**
     * create edit contact activity
     */
    public static Intent createEditContactActivity(Context context) {
        Intent intent = new Intent(context, EditContact.class);
        return intent;
    }

    /**
     * create add contact activity
     */
    public static Intent createAddContactActivity(Context context) {
        Intent intent = new Intent(context, AddContact.class);
        return intent;
    }

    /**
     * create contact details info activity
     */
    public static Intent createDetailsInfoActivity(Context context) {
        Intent intent = new Intent(context, ContactDetailsInfo.class);
        return intent;
    }

    /**
     * create edit profile activity
     */
    public static Intent createEditProfileActivity(Context context) {
        Intent intent = new Intent(context, EditProfile.class);
        return intent;
    }

    /**
     * create list of vechiles activity
     */
    public static Intent createListOfVechilesActivity(Context context) {
        Intent intent = new Intent(context, ListOfVechilesActivity.class);
        return intent;
    }

    /**
     * create basic load  activity
     */
    public static Intent createBasicLoadActivity(Context context) {
        Intent intent = new Intent(context, BasicLoadActivity.class);
        return intent;
    }

    /**
     * create main filter activity
     */
    public static Intent createMainFilterActivity(Context context) {
        Intent intent = new Intent(context, MainFilterActivity.class);
        return intent;
    }

    /**
     * create main filter activity
     */
    public static Intent createTruckBookingConfirmActivity(Context context) {
        Intent intent = new Intent(context, TruckBookingConfirmActivity.class);
        return intent;
    }

    /**
     * create verify otp activity
     */
    public static Intent createVerifyOtpActivity(Context context) {
        Intent intent = new Intent(context, VerifyOtpActivity.class);
        return intent;
    }

    /**
     * more activity
     */

    public static Intent startMoreActivity(Context ctx){
        Intent moreActivity = new Intent(ctx, MoreActivity.class);
        return moreActivity;
    }

    /**
     * about us activity
     */

    public static Intent startAboutUsActivity(Context ctx){
        Intent moreActivity = new Intent(ctx, AboutUsActivity.class);
        return moreActivity;
    }

    /**
     * about app activity
     */

    public static Intent startAboutAppActivity(Context ctx){
        Intent moreActivity = new Intent(ctx, AboutAppActivity.class);
        return moreActivity;
    }

    /**
     * terms of use activity
     */

    public static Intent startTermsOfUseActivity(Context ctx){
        Intent moreActivity = new Intent(ctx, TermsOfUseActivity.class);
        return moreActivity;
    }

    /**
     * privacy policy activity
     */

    public static Intent startPrivacyActivity(Context ctx){
        Intent moreActivity = new Intent(ctx, PrivacyPolicyActivity.class);
        return moreActivity;
    }

    /**
     * membership activity
     */

    public static Intent startMembershipActivity(Context ctx){
        Intent moreActivity = new Intent(ctx, CustomerMembershipActivity.class);
        return moreActivity;
    }

    /**
     * notification activity
     */

    public static Intent startNotificationActivity(Context ctx){
        Intent moreActivity = new Intent(ctx, NotificationActivity.class);
        return moreActivity;
    }

}
