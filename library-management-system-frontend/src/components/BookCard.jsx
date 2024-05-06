import React, { useEffect } from 'react'
import styles from './BookCard.module.css'

const BookCard = ({bookData}) => {

      useEffect(()=>{

      },[bookData])

  return (
    <section className={styles.container}>
      <div className={styles.bookCard}>
         {
            bookData.map((book,id)=>
            <ul className={styles.card} key={id} >
              <li>
                <span className={styles.book}>Book Cover</span>
                <div >
                  <div className={styles.title}>SerialId : </div> <div>{book.serialId}</div>
                </div >
                <div>
                  <div className={styles.title}>Title : </div><div>{book.title}</div>
                </div>
                <div>
                  <div className={styles.title}>Author : </div><div>{book.author}</div>
                </div>
                <div>
                  <dir className={styles.title}>Available : </dir><div>{book.count}</div>
                </div>
              </li>
            </ul>
            )
          } 
      </div>
    </section>
  )
}

export default BookCard
