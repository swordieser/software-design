package ru.quipy.api

import ru.quipy.core.annotations.DomainEvent
import ru.quipy.domain.Event
import java.util.*

const val PROJECT_CREATED_EVENT = "PROJECT_CREATED_EVENT"
const val PROJECT_UPDATED_EVENT = "PROJECT_UPDATED_EVENT"
const val PROJECT_DELETED_EVENT = "PROJECT_DELETED_EVENT"
const val TAG_CREATED_EVENT = "TAG_CREATED_EVENT"
const val TAG_ASSIGNED_TO_TASK_EVENT = "TAG_ASSIGNED_TO_TASK_EVENT"
const val TASK_STATUS_CREATED_EVENT = "TASK_STATUS_CREATED_EVENT"
//const val TASK_CREATED_EVENT = "TASK_CREATED_EVENT"
const val ADD_USER_TO_PROJECT_EVENT = "ADD_USER_TO_PROJECT_EVENT"


// API
@DomainEvent(name = PROJECT_CREATED_EVENT)
class ProjectCreatedEvent(
    val projectId: UUID,
    val creatorId: UUID,
    val title: String,
    val description: String,
    createdAt: Long = System.currentTimeMillis(),
) : Event<ProjectAggregate>(
    name = PROJECT_CREATED_EVENT,
    createdAt = createdAt,
)


@DomainEvent(name = PROJECT_UPDATED_EVENT)
class ProjectInfoUpdatedEvent(
    val userId: UUID,
    val title: String,
    val description: String,
    createdAt: Long = System.currentTimeMillis(),
) : Event<ProjectAggregate>(
    name = PROJECT_UPDATED_EVENT,
    createdAt = createdAt,
)

@DomainEvent(name = PROJECT_DELETED_EVENT)
class ProjectDeletedEvent(
    val userId: UUID,
) : Event<ProjectAggregate>(
    name = PROJECT_DELETED_EVENT,
)

@DomainEvent(name = TAG_CREATED_EVENT)
class TagCreatedEvent(
    val projectId: UUID,
    val tagId: UUID,
    val tagName: String,
    createdAt: Long = System.currentTimeMillis(),
) : Event<ProjectAggregate>(
    name = TAG_CREATED_EVENT,
    createdAt = createdAt,
)

@DomainEvent(name = TASK_STATUS_CREATED_EVENT)
class TaskStatusCreatedEvent(
    val projectId: UUID,
    val statusId: UUID,
    val statusName: String,
    createdAt: Long = System.currentTimeMillis(),
) : Event<ProjectAggregate>(
    name = TAG_CREATED_EVENT,
    createdAt = createdAt,
)

@DomainEvent(name = TAG_ASSIGNED_TO_TASK_EVENT)
class StatusAssignedToTaskEvent(
    val projectId: UUID,
    val taskId: UUID,
    val statusId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<ProjectAggregate>(
    name = TAG_ASSIGNED_TO_TASK_EVENT,
    createdAt = createdAt
)


//@DomainEvent(name = TASK_CREATED_EVENT)
//class TaskCreatedEvent(
//    val projectId: UUID,
//    val taskId: UUID,
//    val taskName: String,
//    createdAt: Long = System.currentTimeMillis(),
//) : Event<ProjectAggregate>(
//    name = TASK_CREATED_EVENT,
//    createdAt = createdAt
//)

@DomainEvent(name = TAG_ASSIGNED_TO_TASK_EVENT)
class TagAssignedToTaskEvent(
    val projectId: UUID,
    val taskId: UUID,
    val tagId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<ProjectAggregate>(
    name = TAG_ASSIGNED_TO_TASK_EVENT,
    createdAt = createdAt
)


@DomainEvent(name = ADD_USER_TO_PROJECT_EVENT)
class AddUserToProjectEvent(
    val projectId: UUID,
    val userId: UUID,
    createdAt: Long = System.currentTimeMillis(),
) : Event<ProjectAggregate>(
    name = ADD_USER_TO_PROJECT_EVENT,
    createdAt = createdAt
)
