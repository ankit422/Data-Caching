package com.testdatacaching

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FragmentHome : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val retrofit = RetroFit()

        retrofit.service.listRepos("MindorksOpenSource")
            .enqueue(object : Callback<MutableList<Repo>> {
                override fun onResponse(
                    call: Call<MutableList<Repo>>,
                    response: Response<MutableList<Repo>>
                ) {
                    Toast.makeText(
                        context, (response.body()?.size ?: 0).toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onFailure(call: Call<MutableList<Repo>>, t: Throwable?) {
                    //Handle failure
                    Log.e("error",(t?.cause ?: "something").toString())
                    Toast.makeText(
                        context, (t?.cause ?: "something").toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })

        return inflater.inflate(R.layout.fragment_view, container, false)
    }

    fun getInstance(i: String): FragmentHome {
        val bundle = Bundle()
        bundle.putString("str", i)
        val frag = FragmentHome()
        frag.arguments = bundle
        return frag
    }

}

