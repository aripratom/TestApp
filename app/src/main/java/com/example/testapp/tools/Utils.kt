package com.example.testapp.tools

import android.util.Log
import android.widget.EditText
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException

object Utils {

    fun getStringResponse(response: Response<ResponseBody>): String {
        var result = ""
        if (response.body() != null) {
            try {
                result = String(response.body()!!.bytes())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return result
    }

    fun isJSONValid(test: String?): Boolean {
        if (test != null) {
            try {
                JSONObject(test)
            } catch (ex: JSONException) {
                Log.d("ValidJSON : ", "$ex")
                // edited, to include @Arthur's comment
// e.g. in case JSONArray is valid as well...
                try {
                    JSONArray(test)
                } catch (ex1: JSONException) {
                    Log.d("JSONFAIL : ", "$ex1")
                    return false
                }
            }
            return true
        }
        return false
    }

    fun setError(editText: EditText, msg: String) {
        editText.requestFocus()
        editText.error = msg
    }

    fun etValidate(editText: EditText, msg: String, listener: () -> Unit) {
        if (etToString(editText).isNotEmpty()) listener()
        else setError(editText, msg)
    }

    fun etToString(editText: EditText): String {
        return editText.text.toString()
    }
}