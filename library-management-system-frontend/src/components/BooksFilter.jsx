import React, { useEffect, useState } from 'react'
import styles from './BooksFilter.module.css'

const BooksFilter = ({booksData,setFilteredBookData,filteredBookData}) => {
  
  const[isSelected,setIsSelected] = useState(false)
  const[categories,setCategories] = useState([])
  const categoryUrl = 'http://localhost:8080/books/category'

  const handleRightClick = ()=>{
    document.getElementById('titleList').scrollLeft+=200;
  }
  const handleLeftClick = ()=>{
    document.getElementById('titleList').scrollLeft-=200;
  }

  // useEffect(()=>{
  //   const fetchCategories = async (categoryUrl)=>{
  //       const response  = await fetch(categoryUrl)
  //       const result = await response.json()
  //       setCategories(result)
  //   }
  //   fetchCategories(categoryUrl)
  //  }, [])

   useEffect(()=>{
      let res=[]
      booksData.map((book,id)=>{
        res[id]=book.category
      })
      setCategories(res)
   },[booksData])
  
  const handleSelect = (e)=>{
          setIsSelected(!isSelected)
          e.target.className = isSelected ? styles.selected :""
          const categoryName = e.target.id
          booksData.forEach(book=>{
              if(isSelected){
                  if(book.category === categoryName){
                    let isPresent = false;
                    const bookData = filteredBookData.map(book=>{
                        book.category===categoryName ? isPresent=true :isPresent=false
                    })
                    !isPresent &&  setFilteredBookData([...filteredBookData,book])
                  }
              }
              else if(!isSelected && e.target.className==="" ) {
                const bookData = filteredBookData.filter(book=>book.category!=categoryName)
                setFilteredBookData(bookData)
              }
           })
  }

  return (
    <div className={styles.container}>
      <img src="src/assets/arrowIcon.png" alt="prevButton"  className={styles.prevButton} onClick={handleLeftClick}/> 
      <ul  id='titleList' >
        {
            categories.map((category,id)=>{
              return  <li key={id}
                            id = {category}
                            onClick={handleSelect}
                            >{category}</li>
            })
        }
      </ul>
      <img src="src/assets/arrowIcon.png" alt="nextButton"  className={styles.nextButton} onClick={handleRightClick}/> 
    </div>
  )
}

export default BooksFilter
