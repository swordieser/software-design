package ru.quipy.logic

import ru.quipy.api.*
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import java.util.*

class TaskAggregateState : AggregateState<UUID, TaskAggregate> {
    private lateinit var taskId: UUID
    var createdAt: Long = System.currentTimeMillis()

    lateinit var projectId: UUID
    lateinit var creatorId: UUID
    lateinit var updaterId: UUID
    lateinit var title: String
    lateinit var description: String
    lateinit var performer: UUID
    lateinit var deadline: Date
    var deleted: Boolean = false

    override fun getId() = taskId

    @StateTransitionFunc
    fun taskCreatedApply(event: TaskCreatedEvent) {
        taskId = event.taskId
        projectId = event.projectId
        creatorId = event.creatorId
        title = event.title
        description = event.description
        performer = event.performer
        deadline= event.deadline
        createdAt = event.createdAt
    }

    @StateTransitionFunc
    fun taskTitleUpdatedApply(event: TaskTitleUpdatedEvent) {
        title = event.title
        updaterId = event.updaterId
    }

//    @StateTransitionFunc
//    fun taskStatusUpdatedApply(event: TaskStatusUpdatedEvent) {
//        taskId = event.taskId
//        status = event.status
//        updaterId = event.updaterId
//        createdAt = event.createdAt
//    }

    @StateTransitionFunc
    fun taskDeletedApply(event: TaskDeletedEvent) {
        updaterId = event.userId
        deleted = true
    }
}
