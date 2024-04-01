package org.example.interfaces;

import java.util.List;

/**
 * Crud-http
 * creat- post
 * read-get(id)- um registro
 * read- get=lista todos
 * update- put(id,objeto),patch(id,objeto) a diferença é que o put atualiza tudo.
 * delete-deletae(id)
 * */

public interface IService<T,N> extends GenericOperations<T,N>{

}
