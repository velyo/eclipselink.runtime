package org.eclipse.persistence.internal.jpa.querydef;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Bindable;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.ManagedType;
import javax.persistence.metamodel.Metamodel;

public class RootImpl<X> extends FromImpl<X, X> implements Root<X> {

    public <T> RootImpl(ManagedType managedType, Metamodel metamodel, Class<X> javaClass, org.eclipse.persistence.expressions.Expression expressionNode, Bindable modelArtifact) {
        super((Path)null, managedType, metamodel, javaClass, expressionNode, modelArtifact);
    }

    /**
     * Return the metamodel entity corresponding to the root.
     * 
     * @return metamodel entity corresponding to the root
     */
    public EntityType<X> getModel(){
        return (EntityType<X>)this.modelArtifact;
    }
    
    public void findRootAndParameters(AbstractQueryImpl query){
        if (query.getRoots().isEmpty()){
            query.integrateRoot(this);
        }
        if (query.getRoots().contains(this)){
            query.getRoots().add(this);
        }
    }


}
