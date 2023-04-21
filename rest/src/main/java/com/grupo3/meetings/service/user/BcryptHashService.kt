package com.grupo3.meetings.service.user

import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
@Qualifier("hashService")
class BcryptHashService : HashService {

  override fun hash(password: String): String {
    var salt = BCrypt.gensalt()
    return BCrypt.hashpw(password, salt)
  }

  override fun areEqual(password: String, hashedPassword: String): Boolean {
    return BCrypt.checkpw(password, hashedPassword)
  }
}