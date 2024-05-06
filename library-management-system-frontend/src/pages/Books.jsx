import React from 'react';
import styles from'./Books.module.css';
import BooksFilter from '../components/BooksFilter';
// import BookCard from '../components/BookCard';
import { useEffect, useState } from 'react';
import LoadingModel from '../components/LoadingModel';
const BookCard  = React.lazy(()=>import('../components/BookCard'))


const Books = ({searchValue,search,setSearch}) => {

    const[booksData,setBooksData] = useState([])
    const[filteredBookData,setFilteredBookData] = useState([])
    const[pageNum,setPageNo] = useState(0)
    const[isBooksPresent,setIsBooksPresent] = useState(true)
    const booksUrl = `http://localhost:8080/books/all?pageNumber=${pageNum}&size=24`
    const getBooksByVal = `http://localhost:8080/books/getByVal?val=${searchValue.toLowerCase()}`
    useEffect( ()=>{
        const scrollEvent = ()=>{
            const scrollY = window.scrollY
            const scrollHeight = document.documentElement.scrollHeight-window.innerHeight
            if(scrollY===scrollHeight){
                isBooksPresent && setPageNo(pageNum+1)
            }
        }
        const fetchBooks = async (booksUrl)=>{
            const response  = await fetch(booksUrl)
            const result = await response.json()
            if(result===undefined || result===null || result.length===0)setIsBooksPresent(false)
            setBooksData([...booksData,...result])
        }
        const event = window.addEventListener('scroll',scrollEvent)
        isBooksPresent && fetchBooks(booksUrl) 
        setFilteredBookData([])
        return()=>{
            window.removeEventListener('scroll',scrollEvent)
        }
    },[pageNum])

    useEffect(()=>{
            const filteredData = booksData.filter(book=>{
            searchValue = searchValue.toLowerCase()
            return (searchValue && book && (
                       book.title.toLowerCase() === searchValue 
                    || book.category.toLowerCase() === searchValue 
                    || book.author.toLowerCase() === searchValue
                    )
                  )
        })
        setSearch(false)
        if(filteredData.length===0){ 
            const fetchBooks = async (booksUrl)=>{
                const response  = await fetch(booksUrl)
                const result = await response.json()
                if(result!=undefined || result!=null || result.length!=0) setFilteredBookData(result);
            }
            fetchBooks(getBooksByVal)   
        }
         search && setFilteredBookData(filteredData)
        
      },[search,searchValue])
    return(
        <>
            <div className= {styles.container} id='booksCard'>
                <BooksFilter booksData = {booksData} setFilteredBookData ={setFilteredBookData} filteredBookData = {filteredBookData} />
                <React.Suspense fallback={<LoadingModel />}>
                    <BookCard  bookData = {(filteredBookData!=null && filteredBookData!=undefined && filteredBookData.length>0) ? filteredBookData:booksData} />
                </React.Suspense>
            </div>
        </>
    )
}
export default Books;