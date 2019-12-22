package com.example.cipherchatzy.Repository;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype. Repository;

import com.example.cipherchatzy.Model.UserModel;


public interface UserPagingRepo extends PagingAndSortingRepository<UserModel, Long> {

}
