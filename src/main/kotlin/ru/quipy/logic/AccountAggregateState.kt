package ru.quipy.logic

import ru.quipy.api.*
import ru.quipy.core.annotations.StateTransitionFunc
import ru.quipy.domain.AggregateState
import java.math.BigDecimal
import java.util.*

class AccountAggregateState : AggregateState<UUID, AccountAggregate> {
    private lateinit var accountId: UUID
    private lateinit var holderId: UUID

    var bankAccounts = mutableMapOf<UUID, BankAccount>()

    override fun getId() = accountId

    @StateTransitionFunc
    fun createNewAccount(event: AccountCreatedEvent) {
        accountId = event.accountId
        holderId = event.userId
    }

    @StateTransitionFunc
    fun createNewBankAccount(event: BankAccountCreatedEvent) {
        bankAccounts[event.bankAccountId] = BankAccount(event.bankAccountId)
    }

    @StateTransitionFunc
    fun deletedBankAccount(event: BankAccountDeletedEvent) {
        bankAccounts[event.bankAccountId] = BankAccount(event.bankAccountId)
    }
}

data class BankAccount(
    val id: UUID = UUID.randomUUID(),
    internal var balance: BigDecimal = BigDecimal.ZERO,
)