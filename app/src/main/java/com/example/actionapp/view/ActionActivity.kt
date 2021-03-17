package com.example.actionapp.view

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.actionapp.R
import com.example.actionapp.di.DependencyInjectorImpl
import com.example.actionapp.module.Action
import com.example.actionapp.presenter.ActionContract
import com.example.actionapp.presenter.ActionPresenter

class ActionActivity: AppCompatActivity(), ActionContract.View  {

    private lateinit var presenter: ActionContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action)
        setPresenter(ActionPresenter(this, DependencyInjectorImpl()))
        presenter.onViewCreated()
    }

    override fun setPresenter(presenter: ActionContract.Presenter) {
        this.presenter = presenter
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun performAction(actions: Array<Action>) {
        // logic to choose the correct action, for organization purposes, I would have call
        // a separated service with actions as parameter.
    }

    override fun displayContactsList() {

        // If I had more time to implement, this would be a call to a separated service, using provider
    }

    override fun displaySimpleToast() {
        val text = "Action is toast!"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

    override fun displayNotification() {
        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, ContactsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val builder = NotificationCompat.Builder(this, "500")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("My notification")
            .setContentText("Action Notification!”")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            // Set the intent that will fire when the user taps the notification
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
    }

    override fun animateActionButton() {
        var  rotate = RotateAnimation(0f, 360f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.duration = 5000;
        rotate.interpolator =  LinearInterpolator();
        var button : Button =  findViewById(R.id.button);
        button.startAnimation(rotate);
    }

}