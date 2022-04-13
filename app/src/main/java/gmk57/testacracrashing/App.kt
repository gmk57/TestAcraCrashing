package gmk57.testacracrashing

import android.app.Application
import android.content.Context
import org.acra.config.httpSender
import org.acra.data.StringFormat
import org.acra.ktx.initAcra
import org.acra.sender.HttpSender

class App : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        if (BuildConfig.DEBUG) return
        initAcra {
            buildConfigClass = BuildConfig::class.java
            reportFormat = StringFormat.JSON

            httpSender {
                uri = "https://example.com/acra_endpoint"
                basicAuthLogin = "secretlogin"
                basicAuthPassword = "secretpassword"
                httpMethod = HttpSender.Method.POST
            }
        }
    }
}
