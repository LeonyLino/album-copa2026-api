package br.com.album_copa.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_users")
data class UserEntity(
    @Column(unique = true, nullable = false)
    var email: String,

    @Column(nullable = false)
    var password: String,

    // @ElementCollection(fetch = FetchType.EAGER)
    // @CollectionTable(name = "user_roles")
    // @Column(name = "role")
    //var roles: Set<String> = setOf("ROLE_USER"),
) : GenericEntity()