package jp.ac.it_college.std.s24016.kotlin.exposed.dao.crud
//delete：IDを指定してデータを削除する(crudのd)
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberEntity
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberTable
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main() {
    createSessionFactory()

    transaction {
        val entity = MemberEntity.findById(4)
        entity?.delete()
    }
}
