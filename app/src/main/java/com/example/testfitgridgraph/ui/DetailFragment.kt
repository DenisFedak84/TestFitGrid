package com.example.testfitgridgraph.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.testfitgridgraph.App
import com.example.testfitgridgraph.LaunchListQuery
import com.example.testfitgridgraph.R
import com.example.testfitgridgraph.presenter.DetailPresenter
import com.example.testfitgridgraph.view.DetailView
import kotlinx.android.synthetic.main.detail_fragment.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class DetailFragment : BaseFragment(), DetailView {

    @Inject
    @InjectPresenter
    lateinit var presenter: DetailPresenter

//    @Inject
//    lateinit var query: LaunchListQuery

    @ProvidePresenter
    fun providePresenter(): DetailPresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.INSTANCE.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnPreview.setOnClickListener { presenter.goToPreview() }
        btnNameDetail.setOnClickListener { getName() }

    }

    override fun getName() {
        val query = LaunchListQuery()
        presenter.getName(query)
    }

    override fun showName(name: String) {
        textView.text = name
    }

    override fun showMessage(msg: String) {
        Toast.makeText(activity,msg,Toast.LENGTH_LONG).show()
    }
}