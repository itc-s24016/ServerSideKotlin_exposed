package jp.ac.it_college.std.s24016.kotlin.exposed.dao.crud
//update：IDを指定してデータを更新する(crudのu)
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberEntity
import jp.ac.it_college.std.s24016.kotlin.exposed.dao.MemberTable
import org.jetbrains.exposed.v1.jdbc.transactions.transaction

fun main() {
    createSessionFactory()

    transaction {
        val entity = MemberEntity.findById(4)
        entity?.let {
            it.name = "Yonro"
        }
    }
}
