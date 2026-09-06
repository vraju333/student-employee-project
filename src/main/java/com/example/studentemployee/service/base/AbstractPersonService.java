package com.example.studentemployee.service.base;
import com.example.studentemployee.entity.BasePerson;
public abstract class AbstractPersonService<T extends BasePerson> { protected abstract T findEntity(Long id); public boolean exists(Long id){ try{findEntity(id);return true;}catch(RuntimeException e){return false;} } }
