package ru.quipy.logic

import java.math.BigDecimal
import ru.quipy.api.*
import java.util.*


// Commands : takes something -> returns event
// Here the commands are represented by extension functions, but also can be the class member functions

fun AccountAggregateState.createNewAccount(id: UUID = UUID.randomUUID(), holderId: UUID): AccountCreatedEvent {
    return AccountCreatedEvent(id, holderId)
}

fun AccountAggregateState.createNewBankAccount(accountId: UUID): BankAccountCreatedEvent {
    return BankAccountCreatedEvent(accountId = this.getId(), bankAccountId = UUID.randomUUID())
}

fun AccountAggregateState.deleteBankAccount(BankAccountId: UUID): BankAccountDeletedEvent {
    return BankAccountDeletedEvent(
        accountId = this.getId(),
        bankAccountId = BankAccountId,
    )
}

//fun AccountAggregateState.deposit(toBankAccountId: UUID, amount: BigDecimal): BankAccountDepositEvent {
//    return BankAccountDepositEvent(
//        accountId = this.getId(),
//        bankAccountId = toBankAccountId,
//        amount = amount
//    )
//}
//
//fun AccountAggregateState.withdraw(fromBankAccountId: UUID, amount: BigDecimal): BankAccountWithdrawalEvent {
//    return BankAccountWithdrawalEvent(
//        accountId = this.getId(),
//        bankAccountId = fromBankAccountId,
//        amount = amount
//    )
//}
//
//fun AccountAggregateState.transferBetweenInternalAccounts(
//    fromBankAccountId: UUID,
//    toBankAccountId: UUID,
//    transferAmount: BigDecimal
//): InternalAccountTransferEvent {
//    return InternalAccountTransferEvent(
//        accountId = this.getId(),
//        bankAccountIdFrom = fromBankAccountId,
//        bankAccountIdTo = toBankAccountId,
//        amount = transferAmount
//    )
//}