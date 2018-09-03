package com.cyclopsdev.gangame.owned

import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.View
import com.cyclopsdev.commons.BaseListFragment
import com.cyclopsdev.commons.DataBindingRecyclerAdapter
import com.cyclopsdev.gangame.R
import com.cyclopsdev.gangame.TopGame
import com.cyclopsdev.commons.BR
import com.cyclopsdev.gangame.Deal
import com.cyclopsdev.gangame.data.GangameDataSource


class TopOwnedFragment : BaseListFragment() {

    override fun getAdapter(): RecyclerView.Adapter<*> {
        return DataBindingRecyclerAdapter<TopGame>(BR.topGame, R.layout.item_top_game)
    }

    override fun onResume() {
        super.onResume()
        showTopOwned()
    }

    private fun showTopOwned() {
        GangameDataSource
                .getMostOwned()
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
                    .setAction(getString(R.string.retry), { _: View -> showTopOwned()})
                    .show()

        }
    }

    private fun replaceItems(list: List<TopGame>){
        with(listAdapter as DataBindingRecyclerAdapter<TopGame>){
            items.clear()
            items.addAll(list)
            notifyDataSetChanged()
        }

    }

}