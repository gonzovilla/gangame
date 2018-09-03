package com.cyclopsdev.gangame.deals

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import com.cyclopsdev.commons.BR
import com.cyclopsdev.commons.BaseListFragment
import com.cyclopsdev.commons.DataBindingRecyclerAdapter
import com.cyclopsdev.gangame.Deal
import com.cyclopsdev.gangame.R
import com.cyclopsdev.gangame.data.GangameDataSource

class DealsFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<Deal>(BR.deal, R.layout.item_deal);
    }

    override fun onResume() {
        super.onResume()
        showDeals()
    }

    private fun showDeals() {
        GangameDataSource
                .getDeals()
                .subscribe({ list ->
                    replaceItems(list)
                }, { error ->
                    showError(error)
                })
    }

    private fun showError(error: Throwable) {
        error.printStackTrace()
        view?.let {
            Snackbar.make(view as View, getString(R.string.error_request), Snackbar.LENGTH_LONG)
                    .setAction(getString(R.string.retry), { _: View -> showDeals()})
                    .show()

        }
    }

    private fun replaceItems(list: List<Deal>){
        with(listAdapter as DataBindingRecyclerAdapter<Deal>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }

    }

}