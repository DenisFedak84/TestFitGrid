package com.example.testfitgridgraph.utils

import moxy.MvpView
import moxy.viewstate.ViewCommand
import moxy.viewstate.strategy.StateStrategy

class AddToEndSingleTagStrategy : StateStrategy {
    override fun <View : MvpView> beforeApply(
        currentState: MutableList<ViewCommand<View>>,
        incomingCommand: ViewCommand<View>
    ) {
        val iterator = currentState.iterator()

        while (iterator.hasNext()) {
            val entry = iterator.next()

            if (entry.tag == incomingCommand.tag) {
                iterator.remove()
            }

        }
        currentState.add(incomingCommand)
    }

    override fun <View : MvpView> afterApply(
        currentState: List<ViewCommand<View>>,
        incomingCommand: ViewCommand<View>
    ) {
    }
}
