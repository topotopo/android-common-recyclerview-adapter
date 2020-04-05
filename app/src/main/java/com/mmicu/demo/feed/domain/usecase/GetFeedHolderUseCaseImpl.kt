package com.mmicu.demo.feed.domain.usecase

import com.mmicu.demo.BR
import com.mmicu.demo.feed.domain.model.MovieModel
import com.mmicu.demo.feed.domain.model.StatusModel
import com.mmicu.demo.feed.presentation.itemviewholder.Empty
import com.mmicu.demo.feed.presentation.itemviewholder.MovieFeedItemHolder
import com.mmicu.demo.feed.presentation.itemviewholder.StatusFeedItemHolder
import com.mmicu.demo.utils.Result
import com.mmicu.commonadapter.CommonItemHolder

class GetFeedHolderUseCaseImpl(private val getFeedUseCase: GetFeedUseCase) : GetFeedHolderUseCase {
    override suspend fun invoke(): List<CommonItemHolder<*>> {
        val response = getFeedUseCase.invoke()
        if (response is Result.Success) {
            return response.data.map {
                when (it) {
                    is MovieModel -> {
                        MovieFeedItemHolder(
                            data = it,
                            variableId = BR.data
                        )
                    }
                    is StatusModel -> {
                        StatusFeedItemHolder(
                            data = it,
                            variableId = BR.data
                        )
                    }
                    else -> {
                        Empty(
                            it ?: "" //TODO: Handle nulls
                        )
                    }
                }

            }
        }
        return listOf()
    }
}