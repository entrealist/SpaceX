package ritwik.samples.spacex.common

import android.os.Bundle

import androidx.annotation.Nullable

import androidx.appcompat.app.AppCompatActivity

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**Base [android.app.Activity] to abstract common instantiation and clean-up procedures.
 * @author Ritwik Jamuar*/
abstract class BaseActivity : AppCompatActivity() {

    /*----------------------------------- Activity Callbacks -------------------------------------*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        if (isDataBinding()) {
            bindView(DataBindingUtil.setContentView(this, layoutRes()))
        } else {
            setContentView(layoutRes())
        }
        initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        cleanUp()
    }

    /*------------------------------------- Abstract Methods -------------------------------------*/

    /**Tells the implementing [android.app.Activity] to provide it's Layout Resource ID.
     * @return [Int] denoting the Layout Resource ID.*/
    abstract fun layoutRes(): Int

    /**Tells the implementing [android.app.Activity] to inject it's [dagger.Component].*/
    abstract fun inject()

    /**Determines from implementing [android.app.Activity] whether it is using Data Binding or not.
     * @return [Boolean] value as true, when implementing [android.app.Activity] is using
     * DataBinding, otherwise false.*/
    abstract fun isDataBinding(): Boolean

    /**Binds the Data Binding adapter that'll be used by the implementing [android.app.Activity].
     * @param binding Data Binding Adapter to be used for any value updates.*/
    abstract fun bindView(@Nullable binding: ViewDataBinding)

    /**Tells the implementing [android.app.Activity] to initialize it's component.*/
    abstract fun initialize()

    /**Tells the implementing [android.app.Activity] to clean-up it's resources.*/
    abstract fun cleanUp()

}