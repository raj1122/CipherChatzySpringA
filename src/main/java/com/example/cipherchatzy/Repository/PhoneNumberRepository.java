/**
 * 
 */
package com.example.cipherchatzy.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cipherchatzy.Model.PhoneNumberModel;

/**
 * @author Raj Kumar
 *
 */

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumberModel, Long> {

}
