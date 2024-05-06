import React, { createContext, useState } from 'react';
import { NavLink, Outlet } from 'react-router-dom';
import styles from './Navigation.module.css';
import Menu from '../components/Menu';
import {createPortal} from 'react-dom'
import SearchContent from '../components/SearchContent';

export const Navigation = ({searchState,setSearchState,searchValue,setSearchValue,setSearch}) => {
    const[isMenuOpen,setIsMenuOpen] = useState(false);
    return(
        <>
        {
            isMenuOpen && createPortal(<Menu isMenuOpen = {setIsMenuOpen} />,document.body)
        }
            <div className={styles.container} id='root'>
                <div className= {styles.home}>
                    <div className={styles.menu}>
                        <img src="src/assets/menuIcon.png" alt="menu" onClick={()=>setIsMenuOpen(true)}/>
                    </div>
                    <h2 className={styles.title}>Library Management System</h2>
                </div>
                <div className={styles.searchBar}>
                    <div className={styles.searchBox}>
                        <input type="search" name='search' placeholder='Search' id="search" 
                            value={searchValue} onChange={(e)=>{ setSearchValue(e.target.value)} }
                            onClick={()=>{ setSearchState(true)}}/>
                        <img src="src/assets/searchImg.png" alt="search" onClick={()=>setSearch(true)} />
                    </div>
                    <div className={styles.searchContent}>
                       { searchState && <SearchContent searchValue={searchValue} setSearchValue = {setSearchValue} />}
                    </div>
                </div>
                <ul>
                    <li>
                        <NavLink to='/'>Home</NavLink>
                    </li>
                </ul>
            </div>
            <Outlet></Outlet>
        </>
    )
}