package com.example.testfitgridgraph.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testfitgridgraph.App
import com.example.testfitgridgraph.R
import com.example.testfitgridgraph.presenter.PreviewPresenter
import com.example.testfitgridgraph.view.PreviewView
import kotlinx.android.synthetic.main.preview_fragment.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class PreviewFragment : BaseFragment(), PreviewView {

    @Inject
    @InjectPresenter
    lateinit var presenter: PreviewPresenter

    @ProvidePresenter
    fun providePresenter(): PreviewPresenter = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.INSTANCE.appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.preview_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnClose.setOnClickListener { presenter.closeAll() }
    }

}