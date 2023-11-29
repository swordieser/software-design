package ru.quipy.logic

import ru.quipy.api.*
import java.util.*


// Commands : takes something -> returns event
// Here the commands are represented by extension functions, but also can be the class member functions

fun ProjectAggregateState.create(id: UUID, title: String, description: String, creatorId: UUID): ProjectCreatedEvent {
    return ProjectCreatedEvent(
        projectId = id,
        creatorId = creatorId,
        title = title,
        description = description
    )
}

fun ProjectAggregateState.update(title: String, description: String, userId: UUID): ProjectInfoUpdatedEvent {
    return ProjectInfoUpdatedEvent(
        userId = userId,
        title = title,
        description = description
    )
}


fun ProjectAggregateState.delete(userId: UUID): ProjectDeletedEvent {
    return ProjectDeletedEvent(
        userId = userId,
    )
}

//fun ProjectAggregateState.addTask(name: String): TaskCreatedEvent {
//    return TaskCreatedEvent(projectId = this.getId(), taskId = UUID.randomUUID(), taskName = name)
//}

fun ProjectAggregateState.createTag(name: String): TagCreatedEvent {
    if (projectTags.values.any { it.name == name }) {
        throw IllegalArgumentException("Tag already exists: $name")
    }
    return TagCreatedEvent(projectId = this.getId(), tagId = UUID.randomUUID(), tagName = name)
}

fun ProjectAggregateState.assignTagToTask(tagId: UUID, taskId: UUID): TagAssignedToTaskEvent {
    if (!projectTags.containsKey(tagId)) {
        throw IllegalArgumentException("Tag doesn't exists: $tagId")
    }

    if (!tasks.containsKey(taskId)) {
        throw IllegalArgumentException("Task doesn't exists: $taskId")
    }

    return TagAssignedToTaskEvent(projectId = this.getId(), tagId = tagId, taskId = taskId)
}

fun ProjectAggregateState.createStatus(name: String): TaskStatusCreatedEvent {
    if (projectStatuses.values.any { it.name == name }) {
        throw IllegalArgumentException("Task status already exists: $name")
    }
    return TaskStatusCreatedEvent(projectId = this.getId(), statusId = UUID.randomUUID(), statusName = name)
}

fun ProjectAggregateState.assignStatusToTask(statusId: UUID, taskId: UUID): StatusAssignedToTaskEvent {
    if (!projectStatuses.containsKey(statusId)) {
        throw IllegalArgumentException("Status doesn't exists: $statusId")
    }

    if (!tasks.containsKey(taskId)) {
        throw IllegalArgumentException("Task doesn't exists: $taskId")
    }

    return StatusAssignedToTaskEvent(projectId = this.getId(), statusId = statusId, taskId = taskId)
}

fun ProjectAggregateState.addUserToProject(userId: UUID): AddUserToProjectEvent {
    return AddUserToProjectEvent(projectId = this.getId(), userId = userId)
}



