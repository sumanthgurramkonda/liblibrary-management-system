import React, { useEffect, useState } from 'react'
import styles from './SearchContent.module.css'

const SearchContent = ({searchValue,setSearchValue}) => {

    const[result,setResult] = useState([])
    const[searchContent,setsearchContent] = useState([''])
    const booksUrl = 'http://localhost:8080/books/allBooks'

    useEffect(()=>{ 

        const fetchBooks = async ()=>{
            const response = await fetch(booksUrl)
            const result = await response.json()
            result.map(book=>{
                setsearchContent((prevState)=>{
                    return [...prevState,book.title]
                })
                setsearchContent((prevState)=>{
                    return [...prevState,book.author]
                })
                setsearchContent((prevState)=>{
                    return [...prevState,book.category]
                })
                
            })
        }
        fetchBooks()
    },[])
    let count = 0;
    useEffect(()=>{
        setResult(
            searchContent.filter((value)=>{ 
                let bool = false
                if(count<5) {
                    bool = value.toLowerCase().startsWith(searchValue.toLowerCase()) && (value.length>1 && value.toLowerCase().includes(searchValue.toLowerCase())) 
                }
                if(bool===true)count++;
                return bool;
            })
        )
     },[searchValue])

  return (
    <div className={styles.searchContainer}>
        <ul>
        {
           result && result.map((content)=>{
                return(
                        <li key={content} onClick={()=>setSearchValue(content)}>
                            <img src="/src/assets/SearchIcon.png" alt="Search" />
                            <div>{content}</div>
                        </li>
                )
            })
        }
        {result && result.length === 0 && <li>Not Found</li>}
        </ul>
    </div>
  )
}

export default SearchContent
