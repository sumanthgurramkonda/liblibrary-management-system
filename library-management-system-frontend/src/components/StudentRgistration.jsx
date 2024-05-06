import React, { useEffect, useState } from 'react'
import styles from './StudentRegistration.module.css'
import Links from '../Links.json'

const StudentRgistration = () => {

    const[student,setStudent] = useState({rollNumber:0,firstName:'',lastName:'',mail:'',mobileNumber:0})
    const[isError,setIsError] = useState(false)

    const formData = [{
        lable : 'Roll Number',
        type : 'number',
        name : 'rollNumber',
        id   :  'rollNumber',
        placeholder : '12345',
        error : 'Please Enter Valid roll Number'
    },
    {
        lable : 'FirstName',
        type : 'text',
        name : 'firstName',
        id   :  'firstName',
        placeholder : 'Christopher',
        error : 'Name should only contain characters from (A-Z) & (a-z)'
    },
    {
        lable : 'LastName',
        type : 'text',
        name : 'lastName',
        id   :  'lastName',
        placeholder : 'Nolan',
        error : 'Name should only contain characters from (A-Z) & (a-z)'
    },
    {
        lable : 'Mail',
        type : 'text',
        name : 'mail',
        id   :  'mail',
        placeholder : 'christopher.nolan@gmail.com',
        error : 'please Enter a Valid mail'
    },
    {
        lable : 'Mobile Number',
        type : 'number',
        name : 'mobileNumber',
        id   :  'mobileNumber',
        placeholder : '+91 3458292177',
        error : 'Please Enter Valid Mobile Number'
    }]
    const hadleInputChange = (e) =>{
        const validateData = (value,id)=>{
            const elemet = document.getElementById(id);
           
           if(value!=undefined){
                // value.map((val,id)=>{
                //     if(val>='a' && val<='z' && val>='A' && val<='Z'){
                //         setIsError(false)
                //     }
                //     else {
                //         setIsError(true)
                //         elemet.className = styles.error
                //         return 
                //     }
                // })
           }
        }

        if(e.target.name==='rollNumber'){
            setStudent(prevStudent=>({
                ...prevStudent , rollNumber : e.target.value
            }));
        }
        if(e.target.name==='firstName'){
            setStudent(prevStudent=>({
                ...prevStudent , firstName : e.target.value
            }));
            validateData(e.target.value,'firstName')
        }
        if(e.target.name==='lastName'){
            setStudent(prevStudent=>({
                ...prevStudent , lastName : e.target.value
            }));
            validateData(e.target.value,"lastName")
        }
        if(e.target.name==='mail'){
            setStudent(prevStudent=>({
                ...prevStudent , email : e.target.value
            }));
            validateData(e.target.value,'mail')
        }
        if(e.target.name==='mobileNumber'){
            setStudent(prevStudent=>({
                ...prevStudent , mobNumber : e.target.value
            }));
        }
        console.log(student)
    }

    const handleSubmit = async (e)=>{
        if(e!= undefined){
            e.preventDefault()
            await fetch(Links.saveStudent,{
                method :'POST',
                headers :{
                    'Accept' : 'application/json',
                    'Content-Type':'application/json'
                },
                body : JSON.stringify(student)
            })
            .then(res=>{
                console.log(res)
                window.alert(res)
            })
            .catch(err=>{
                console.log(err)
                window.alert(err)
            })
       }
    }

    useEffect(()=>{
        handleSubmit();
    },[])

  return (
    <div className={styles.container}>
        <div className={styles.registerForm}>
            <h2 className={styles.title}>Register Student</h2>
            <form action="">
                <ul>
                    {
                        formData.map((data,id)=>{
                            return(
                                <li key={id}>
                                    <label htmlFor="">{data.lable}</label>
                                     <div className={styles.inputContainer}>
                                        <input type={data.type} 
                                        name={data.name} 
                                        id={data.id} 
                                        placeholder={data.placeholder} 
                                        value={student.value} 
                                        onChange={hadleInputChange}/>
                                        <div id={data.id} className={isError ? styles.error:styles.valid} >{data.error}</div>
                                    </div>
                                </li>
                            )
                        })
                    }
                </ul>
                <button className={styles.submit} onClick={handleSubmit}>Submit</button>
            </form>
        </div>
    </div>
  )
}

export default StudentRgistration
