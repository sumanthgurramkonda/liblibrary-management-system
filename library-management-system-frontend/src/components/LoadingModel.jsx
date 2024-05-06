import React from 'react';
import styles from './LoadingModel.module.css'

const LoadingModel = () => {
    return(
       
       <div className={styles.container}>
        <div className={styles.loading}>
            Loading...
        </div>
       </div>
    )
}
export default LoadingModel;